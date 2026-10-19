package org.sunms.designpattern.creational.factorymethod;

/**
 * 모든 커피 머신의 부모 클래스입니다.
 * 주문 처리 흐름({@link #order()})은 직접 구현하고, "무슨 커피를 만들지({@link #createCoffee()})"만
 * 자식에게 맡깁니다.
 *
 * <p><b>역할:</b> Creator (생성자: 공통 흐름 + 팩토리 메서드 선언)<br>
 * 패턴 전체 설명은 {@link MainFactoryMethod#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>왜 인터페이스가 아니라 "추상 클래스"인가?</h2>
 * <p>인터페이스는 "규격(메서드 이름)"만 정하는 곳이라, 공통 코드를 담기에 적합하지 않습니다.
 * 이 클래스는 두 가지를 동시에 해야 합니다.</p>
 * <ol>
 *   <li>{@code order()}: 모든 머신이 똑같이 쓰는 "공통 흐름"을 구현해서 물려줌 → 구현 코드가 필요</li>
 *   <li>{@code createCoffee()}: 머신마다 다른 부분은 비워 둠 → {@code abstract} 메서드</li>
 * </ol>
 * <p>→ "일부는 구현, 일부는 비워 둠" = 추상 클래스가 딱 맞습니다.</p>
 *
 * <h2>왜 추상화가 필요한가? (추상 클래스가 없다면?)</h2>
 * <ul>
 *   <li>아메리카노 머신, 라떼 머신이 각자 {@code order()}를 전부 따로 작성해야 합니다.</li>
 *   <li>"주문 접수 → 만들기 → 서빙" 코드가 머신마다 복사되고,
 *       서빙 방식이 바뀌면 모든 머신을 하나하나 고쳐야 합니다.</li>
 *   <li>→ 추상 클래스로 공통 흐름을 한곳에 모으면, 수정도 한 곳에서 끝납니다.</li>
 *   <li>→ 또한 {@code abstract} 클래스는 {@code new}로 직접 만들 수 없어서,
 *       "어떤 커피인지 모르는 머신"이 생기는 걸 막아 줍니다.</li>
 * </ul>
 *
 * @see AmericanoMachineFactoryMethod
 * @see LatteMachineFactoryMethod
 */
public abstract class CoffeeMachineFactoryMethod {

    /**
     * ★ 팩토리 메서드(Factory Method) ★ 어떤 커피를 만들지 결정합니다.
     *
     * <ul>
     *   <li>{@code abstract}: 부모는 "무엇을 만들지" 모름. 자식이 반드시 구현해야 함.</li>
     *   <li>{@code protected}: 외부가 아닌 자식 클래스에서만 구현/사용하도록</li>
     * </ul>
     *
     * @return 이 머신이 만드는 커피 객체
     */
    protected abstract CoffeeFactoryMethod createCoffee();

    /**
     * 주문을 처리합니다. 모든 머신이 똑같이 사용하는 공통 흐름입니다.
     *
     * <p>이 메서드 안에는 {@code new Americano()} 같은 구체 클래스 이름이 전혀 없습니다!
     * 오직 인터페이스({@link CoffeeFactoryMethod})에만 의존하므로 결합도가 낮습니다.</p>
     *
     * @return 완성된 커피
     */
    public CoffeeFactoryMethod order() {
        System.out.println("  주문 접수!");

        CoffeeFactoryMethod coffee = createCoffee(); // ← 어떤 커피가 나올지는 자식이 결정
        System.out.println("  만들 메뉴: " + coffee.getName());

        coffee.brew();                               // 커피 만들기
        System.out.println("  컵에 담아 서빙합니다. 맛있게 드세요!");
        return coffee;
    }
}
