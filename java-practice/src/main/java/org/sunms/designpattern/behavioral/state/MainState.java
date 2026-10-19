package org.sunms.designpattern.behavioral.state;

/**
 * 상태 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 *
 * <h2>확인할 포인트</h2>
 * <ul>
 *   <li>똑같이 {@code selectDrink()}를 불러도, 현재 상태에 따라 결과가 다르다.</li>
 *   <li>"(상태 변경: A → B)" 출력을 따라가며 상태 흐름을 확인해 보세요.</li>
 * </ul>
 */
public class MainState {

    /**
     * <b>상태 패턴(State Pattern)</b>: 객체의 "상태"마다 클래스를 만들어서,
     * 상태에 따라 행동이 자동으로 바뀌게 하는 행위 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>자판기는 상태에 따라 같은 버튼도 다르게 동작합니다.</p>
     * <ul>
     *   <li>동전 없음 상태: 음료 버튼 → "동전을 넣어 주세요"</li>
     *   <li>동전 있음 상태: 음료 버튼 → 음료 배출</li>
     *   <li>품절 상태: 동전 투입 → 동전 반환</li>
     * </ul>
     * <p>if 문으로 만들면?</p>
     * <pre>{@code
     * public void selectDrink() {
     *     if (state == NO_COIN)       { ... }
     *     else if (state == HAS_COIN) { ... }
     *     else if (state == SOLD_OUT) { ... }
     * }
     * public void insertCoin() { if ... else if ... else if ... }   // ← 모든 메서드에 반복!
     * }</pre>
     * <p>→ 상태가 하나 추가되면 모든 메서드의 if 문을 다 고쳐야 합니다.</p>
     *
     * <h4>해결 방법</h4>
     * <ol>
     *   <li>상태마다 클래스를 만든다 → {@code NoCoinState}, {@code HasCoinState}, {@code SoldOutState}</li>
     *   <li>각 상태 클래스가 "그 상태일 때의 행동"을 구현한다</li>
     *   <li>자판기(Context)는 현재 상태 객체에게 행동을 맡긴다 → if 문이 사라짐!</li>
     *   <li>상태 전환은 상태 객체가 직접 한다 (예: 동전 넣으면 {@code HasCoinState}로 바꿔줘)</li>
     * </ol>
     *
     * <h4>실생활 비유</h4>
     * <p>신호등: 빨강 → 초록 → 노랑 → 빨강 ...
     * 같은 "다음" 버튼이라도 현재 색에 따라 다음 색이 다릅니다.</p>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>State</b>: {@link VendingMachineState} (상태별 행동의 공통 규격, 인터페이스)</li>
     *   <li><b>Concrete State</b>: {@link NoCoinState}, {@link HasCoinState}, {@link SoldOutState}</li>
     *   <li><b>Context</b>: {@link VendingMachineContextState} (자판기, 현재 상태를 들고 있음)</li>
     * </ul>
     *
     * <h4>전략 패턴과의 차이 (구조가 거의 똑같음!)</h4>
     * <ul>
     *   <li><b>전략</b>: 바깥(사용자)이 전략을 골라서 넣어 줌. 전략끼리는 서로 모름.</li>
     *   <li><b>상태</b>: 상태가 "스스로" 다음 상태로 전환함. 상태끼리 서로 알고 있음.</li>
     * </ul>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 거대한 if/switch 제거, 상태별 코드가 한 파일에 모여 이해하기 쉬움</li>
     *   <li><b>단점</b>: 상태가 적을 때는 오히려 클래스만 많아져 과할 수 있음</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>주문 상태: 주문접수 → 결제완료 → 배송중 → 배송완료 (각 상태에서 "취소" 동작이 다름)</li>
     *   <li>게임 캐릭터 상태: 걷기/달리기/점프/기절</li>
     *   <li>TCP 연결 상태, 문서 결재 상태 (작성중 → 검토중 → 승인)</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        VendingMachineContextState machine = new VendingMachineContextState(2);   // 재고 2개

        System.out.println("===== 1. 동전 없이 음료 버튼 누르기 =====");
        machine.selectDrink();

        System.out.println();
        System.out.println("===== 2. 정상 구매 =====");
        machine.insertCoin();
        machine.selectDrink();

        System.out.println();
        System.out.println("===== 3. 동전 넣었다가 반환 =====");
        machine.insertCoin();
        machine.returnCoin();

        System.out.println();
        System.out.println("===== 4. 마지막 음료 구매 → 품절 상태로 =====");
        machine.insertCoin();
        machine.selectDrink();

        System.out.println();
        System.out.println("===== 5. 품절 상태에서 동전 넣기 =====");
        machine.insertCoin();

        System.out.println();
        System.out.println("===== 6. 재고 보충 후 다시 구매 =====");
        machine.refill(5);
        machine.insertCoin();
        machine.selectDrink();
    }
}
