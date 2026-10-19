package org.sunms.designpattern.structural.decorator;

/**
 * 데코레이터 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 */
public class MainDecorator {

    /**
     * 주문 내역(설명과 가격)을 출력합니다.
     * 몇 겹으로 포장됐든 상관없이 같은 방법으로 출력할 수 있습니다.
     *
     * @param beverage 출력할 음료
     */
    static void printOrder(BeverageDecorator beverage) {
        System.out.println("  주문: " + beverage.getDescription() + "  →  " + beverage.getCost() + "원");
    }

    /**
     * <b>데코레이터 패턴(Decorator Pattern)</b>: 기존 객체를 "포장지로 감싸듯" 덧씌워서,
     * 기능을 동적으로 추가하는 구조 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나? (클래스 폭발 문제)</h4>
     * <p>카페 메뉴: 아메리카노 + (우유, 샷 추가, 휘핑크림) 토핑 조합. 상속으로 해결하려 하면?</p>
     * <pre>{@code
     * AmericanoWithMilk, AmericanoWithShot, AmericanoWithMilkAndShot,
     * AmericanoWithMilkAndShotAndWhip, ...
     * }</pre>
     * <p>→ 토핑이 3개만 돼도 조합이 8가지! 토핑이 늘면 클래스가 폭발적으로 증가합니다.</p>
     *
     * <h4>해결 방법</h4>
     * <p>토핑을 "포장지(Decorator)" 클래스로 만들고, 음료를 겹겹이 감쌉니다.</p>
     * <pre>{@code
     * new WhippedCreamDecorator( new MilkDecorator( new AmericanoDecorator() ) )
     * }</pre>
     * <ul>
     *   <li>바깥 포장지가 안쪽에 일을 맡기고, 자기 몫(가격, 이름)만 덧붙임</li>
     *   <li>러시아 인형(마트료시카)처럼 겹겹이!</li>
     * </ul>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Component</b>: {@link BeverageDecorator} (음료 공통 규격, 인터페이스)</li>
     *   <li><b>Concrete Component</b>: {@link AmericanoDecorator} (포장될 기본 음료)</li>
     *   <li><b>Decorator</b>: {@link ToppingDecorator} (포장지의 공통 틀, 추상 클래스)</li>
     *   <li><b>Concrete Decorator</b>: {@link MilkDecorator}, {@link ShotDecorator}, {@link WhippedCreamDecorator}</li>
     * </ul>
     *
     * <h4>핵심 비밀</h4>
     * <p>Decorator도 {@link BeverageDecorator}를 구현한다!
     * → 포장된 음료도 "음료"이므로, 또 포장할 수 있다 (무한 중첩 가능)</p>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 상속 없이 기능을 자유롭게 조합, 실행 중에 기능 추가 가능</li>
     *   <li><b>단점</b>: 작은 객체가 많이 생기고, 겹겹이 감싸져 있어 디버깅이 헷갈릴 수 있음</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>자바 I/O: {@code new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")))}
     *       ← 바로 이게 데코레이터 패턴입니다!</li>
     *   <li>{@code Collections.unmodifiableList(list)}, {@code Collections.synchronizedList(list)}</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {

        System.out.println("===== 1. 기본 아메리카노 =====");
        BeverageDecorator coffee = new AmericanoDecorator();
        printOrder(coffee);

        System.out.println();
        System.out.println("===== 2. 한 겹씩 포장해 보기 =====");
        coffee = new MilkDecorator(coffee);            // 아메리카노를 우유로 감쌈
        printOrder(coffee);
        coffee = new ShotDecorator(coffee);            // 그걸 또 샷으로 감쌈
        printOrder(coffee);
        coffee = new WhippedCreamDecorator(coffee);    // 그걸 또 휘핑으로 감쌈
        printOrder(coffee);

        System.out.println();
        System.out.println("===== 3. 한 줄로 조합 (샷 2번 추가도 가능!) =====");
        BeverageDecorator doubleShot =
                new ShotDecorator(new ShotDecorator(new AmericanoDecorator()));
        printOrder(doubleShot);

        /*
         * [getCost() 가 호출될 때 실제로 일어나는 일]  (3번 doubleShot 기준)
         *
         *   바깥 Shot.getCost()
         *     → 안쪽 Shot.getCost() 를 호출
         *         → Americano.getCost() 를 호출 → 4000 반환
         *       ← 4000 + 600 = 4600 반환
         *   ← 4600 + 600 = 5200 반환
         *
         *   양파 껍질을 벗기듯 안쪽으로 들어갔다가, 나오면서 값을 더해 옵니다.
         */
    }
}
