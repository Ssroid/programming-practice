package org.sunms.designpattern.behavioral.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 전략 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 */
public class MainStrategy {

    /**
     * <b>전략 패턴(Strategy Pattern)</b>: "방법(알고리즘)"을 객체로 분리해서,
     * 상황에 따라 갈아 끼울 수 있게 하는 행위 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>쇼핑몰 결제 코드:</p>
     * <pre>{@code
     * if (method.equals("카드"))          { ... 카드 결제 로직 ... }
     * else if (method.equals("카카오페이")) { ... 카카오페이 로직 ... }
     * else if (method.equals("현금"))      { ... 현금 로직 ... }
     * }</pre>
     * <ul>
     *   <li>결제 수단이 추가될 때마다 이 if-else를 계속 수정해야 함</li>
     *   <li>결제 로직들이 한 메서드에 뒤섞여 점점 거대해짐</li>
     * </ul>
     *
     * <h4>해결 방법</h4>
     * <ol>
     *   <li>각 결제 방법을 별도 클래스(전략)로 분리 → {@code CardPaymentStrategy}, {@code KakaoPayStrategy} ...</li>
     *   <li>공통 인터페이스({@code PaymentStrategy})로 묶음</li>
     *   <li>장바구니(Context)는 "어떤 전략인지 모른 채" {@code strategy.pay()}만 호출</li>
     * </ol>
     *
     * <h4>실생활 비유</h4>
     * <p>게임 캐릭터의 "무기 교체": 칼 → 활 → 마법봉.
     * 캐릭터는 그대로이고, {@code attack()} 하면 장착된 무기에 따라 공격 방식이 바뀝니다.</p>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Strategy</b>: {@link PaymentStrategy} (결제 방법의 공통 규격, 인터페이스)</li>
     *   <li><b>Concrete Strategy</b>: {@link CardPaymentStrategy}, {@link KakaoPayStrategy}, {@link CashPaymentStrategy}</li>
     *   <li><b>Context</b>: {@link ShoppingCartStrategy} (전략을 받아서 사용하는 쪽)</li>
     * </ul>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: if-else 제거, 새 전략 추가 시 기존 코드 수정 불필요, 실행 중 전략 교체 가능</li>
     *   <li><b>단점</b>: 전략 클래스가 많아질 수 있음 (→ 람다로 줄일 수 있음, 아래 2번 예제 참고)</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>{@code Collections.sort(list, Comparator)}: {@code Comparator}가 바로 "정렬 전략"!</li>
     *   <li>스프링의 의존성 주입(DI): 인터페이스에 어떤 구현체를 넣을지 바꿔 끼우는 것 자체가 전략 패턴</li>
     *   <li>할인 정책(정액 할인 / 정률 할인) 교체</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        ShoppingCartStrategy cart = new ShoppingCartStrategy();
        cart.addItem("키보드", 59000);
        cart.addItem("마우스", 31000);

        System.out.println("===== 1. 같은 장바구니, 다른 결제 전략 =====");
        cart.checkout(new CardPaymentStrategy("1234-5678-9012-3456"));
        cart.checkout(new KakaoPayStrategy("010-1234-5678"));
        cart.checkout(new CashPaymentStrategy(100000));

        System.out.println();
        System.out.println("===== 2. 람다로 즉석에서 새 전략 만들기 =====");
        // 인터페이스에 메서드가 1개뿐이라 클래스를 따로 안 만들고 람다로도 전략을 만들 수 있음
        PaymentStrategy pointPay = amount ->
                System.out.println("  [포인트 결제] " + amount + " 포인트 차감 완료");
        cart.checkout(pointPay);   // ShoppingCartStrategy 코드는 수정 0줄!

        System.out.println();
        System.out.println("===== 3. [보너스] 자바에 이미 있는 전략 패턴: Comparator =====");
        List<String> fruits = new ArrayList<>(List.of("바나나", "사과", "파인애플", "귤"));

        fruits.sort(Comparator.naturalOrder());                // 전략 ①: 가나다순
        System.out.println("  가나다순   : " + fruits);

        fruits.sort(Comparator.comparing(String::length));     // 전략 ②: 글자 수 순
        System.out.println("  글자 수 순 : " + fruits);
        // sort() 메서드는 그대로인데, 넘겨주는 "정렬 전략"만 바꿨더니 결과가 달라짐!
    }
}
