package org.sunms.designpattern.creational.factorymethod;

/**
 * 팩토리 메서드 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 *
 * <h2>확인할 포인트</h2>
 * <ul>
 *   <li>{@code main}에는 {@code new AmericanoFactoryMethod()} 같은 "커피 클래스 이름"이 등장하지 않는다.</li>
 *   <li>어떤 머신을 쓰느냐에 따라 나오는 커피가 달라진다.</li>
 * </ul>
 */
public class MainFactoryMethod {

    /**
     * <b>팩토리 메서드 패턴(Factory Method Pattern)</b>: "어떤 객체를 {@code new} 할지"를 부모가 아니라
     * "자식 클래스"가 결정하게 하는 생성 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>커피를 주문받는 코드에 이런 식의 코드가 있다고 해봅시다.</p>
     * <pre>{@code
     * if (type.equals("아메리카노")) coffee = new Americano();
     * else if (type.equals("라떼"))  coffee = new Latte();
     * ... (메뉴가 늘 때마다 여기를 계속 수정해야 함!)
     * }</pre>
     * <ul>
     *   <li>새 메뉴(바닐라라떼)가 추가될 때마다 주문 코드를 뜯어고쳐야 합니다.</li>
     *   <li>주문 로직(컵 준비, 서빙)과 생성 로직({@code new})이 한데 엉켜 있습니다.</li>
     * </ul>
     *
     * <h4>해결 방법</h4>
     * <ol>
     *   <li>공통 흐름(주문 → 만들기 → 컵에 담기 → 서빙)은 부모 클래스에 한 번만 작성</li>
     *   <li>"어떤 커피를 {@code new} 할지"만 추상 메서드 {@code createCoffee()}로 비워 둠</li>
     *   <li>자식 클래스(아메리카노 머신, 라떼 머신)가 {@code createCoffee()}를 채움</li>
     * </ol>
     * <p>→ 새 메뉴 추가 = 새 자식 클래스 1개 추가. 기존 코드는 수정할 필요 없음!<br>
     * (이것을 "OCP: 확장에는 열려 있고, 수정에는 닫혀 있다" 원칙이라고 합니다)</p>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Product</b>: {@link CoffeeFactoryMethod} (커피 공통 규격, 인터페이스)</li>
     *   <li><b>Concrete Product</b>: {@link AmericanoFactoryMethod}, {@link LatteFactoryMethod}</li>
     *   <li><b>Creator</b>: {@link CoffeeMachineFactoryMethod} (공통 흐름 + 팩토리 메서드 선언, 추상 클래스)</li>
     *   <li><b>Concrete Creator</b>: {@link AmericanoMachineFactoryMethod}, {@link LatteMachineFactoryMethod}</li>
     * </ul>
     *
     * <h4>실생활 비유</h4>
     * <p>커피 체인 본사(부모)가 "주문 받는 매뉴얼"을 정해 두고,
     * 각 전용 머신(자식)이 "어떤 커피를 뽑을지"만 담당합니다.</p>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 새 제품 추가가 쉬움, 생성 코드와 사용 코드 분리</li>
     *   <li><b>단점</b>: 제품마다 클래스가 늘어남</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>{@code java.util.Calendar.getInstance()}, {@code NumberFormat.getInstance()}</li>
     *   <li>스프링의 {@code FactoryBean}</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {

        // 변수 타입은 부모(CoffeeMachineFactoryMethod) → 어떤 머신이든 담을 수 있음 (다형성)
        CoffeeMachineFactoryMethod machine;

        System.out.println("===== 아메리카노 머신으로 주문 =====");
        machine = new AmericanoMachineFactoryMethod();
        machine.order();

        System.out.println();
        System.out.println("===== 라떼 머신으로 주문 =====");
        machine = new LatteMachineFactoryMethod();
        machine.order();   // 같은 order() 호출인데 결과가 다름!

        /*
         * [새 메뉴 "바닐라라떼"를 추가하려면?]
         *   1) VanillaLatteFactoryMethod implements CoffeeFactoryMethod  만들기
         *   2) VanillaLatteMachineFactoryMethod extends CoffeeMachineFactoryMethod 만들기
         *   → 기존 파일은 수정 0줄!
         */
    }
}
