package org.sunms.designpattern.behavioral.state;

/**
 * "자판기의 상태라면 동전 투입, 음료 선택, 동전 반환에 각자 반응할 수 있어야 한다"는 규격입니다.
 *
 * <p><b>역할:</b> State (상태별 행동의 공통 규격)<br>
 * 패턴 전체 설명은 {@link MainState#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>동전 없음, 동전 있음, 품절 상태가 각각 이 규격을 자기 방식대로 구현합니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <p>자판기(Context)가 "지금 무슨 상태인지 묻지 않고" 행동을 맡길 수 있게 하기 위해서입니다.</p>
 * <pre>{@code
 * private VendingMachineState state;      // 어떤 상태든 담을 수 있는 변수
 * public void selectDrink() {
 *     state.selectDrink(this);            // if 문 없이 현재 상태에게 위임!
 * }
 * }</pre>
 * <p>→ {@code state} 변수에 다른 상태 객체를 넣기만 하면, 같은 {@code selectDrink()}의 동작이 바뀝니다.</p>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>상태를 {@code int}나 {@code enum} 값으로만 들고 있으면, 자판기의 모든 메서드 안에
 * {@code if (state == 동전없음) ... else if (state == 동전있음) ...}가 반복됩니다.
 * "점검 중" 상태가 추가되면 모든 메서드의 if 문을 하나하나 찾아서 고쳐야 하죠.</p>
 * <ul>
 *   <li>→ 상태를 인터페이스로 추상화하면,
 *       "상태가 추가된다" = "이 인터페이스를 구현한 클래스 1개 추가"로 끝납니다.</li>
 *   <li>→ 한 상태의 모든 행동이 한 클래스에 모여 있어서, 상태별 동작을 이해하기도 쉽습니다.</li>
 * </ul>
 *
 * @see NoCoinState
 * @see HasCoinState
 * @see SoldOutState
 * @see VendingMachineContextState
 */
public interface VendingMachineState {

    /**
     * 동전을 넣었을 때의 행동입니다.
     *
     * @param machine 이 상태를 가진 자판기 (상태 전환에 사용)
     */
    void insertCoin(VendingMachineContextState machine);

    /**
     * 음료 버튼을 눌렀을 때의 행동입니다.
     *
     * @param machine 이 상태를 가진 자판기 (상태 전환에 사용)
     */
    void selectDrink(VendingMachineContextState machine);

    /**
     * 반환 레버를 당겼을 때의 행동입니다.
     *
     * @param machine 이 상태를 가진 자판기 (상태 전환에 사용)
     */
    void returnCoin(VendingMachineContextState machine);

    /**
     * 상태 이름을 알려줍니다. (출력용)
     *
     * @return 상태 이름 (예: "동전 없음")
     */
    String getName();
}
