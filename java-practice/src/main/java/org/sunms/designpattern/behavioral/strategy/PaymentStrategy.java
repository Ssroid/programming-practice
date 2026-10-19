package org.sunms.designpattern.behavioral.strategy;

/**
 * "결제 수단이라면 금액을 받아서 결제({@link #pay(int)})할 수 있어야 한다"는 규격입니다.
 *
 * <p><b>역할:</b> Strategy (전략의 공통 규격)<br>
 * 패턴 전체 설명은 {@link MainStrategy#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>카드, 카카오페이, 현금처럼 결제 "방법"이 각각 하나의 전략이 됩니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <p>장바구니({@link ShoppingCartStrategy})가 결제 방법을 "모르는 채로" 결제를 맡길 수 있게 하기 위해서입니다.</p>
 * <pre>{@code
 * public void checkout(PaymentStrategy strategy) {
 *     strategy.pay(total);   // 카드인지 현금인지 몰라도 됨!
 * }
 * }</pre>
 * <p>→ 장바구니는 "결제를 한다"는 사실만 알고, "어떻게 결제하는지"는 전략 객체가 담당합니다.</p>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>장바구니 안에 {@code if (카드) ... else if (카카오페이) ... else if (현금) ...}가 들어가야 합니다.</p>
 * <ul>
 *   <li>포인트 결제를 추가하려면 장바구니 코드를 열어서 수정해야 하고</li>
 *   <li>결제 로직이 많아질수록 장바구니 클래스가 끝없이 커집니다.</li>
 * </ul>
 * <p>→ 인터페이스로 "결제 방법"을 추상화하면, 새 결제 수단 = 새 클래스 1개 추가로 끝납니다. (OCP)</p>
 *
 * <h2>{@code @FunctionalInterface}란?</h2>
 * <p>추상 메서드가 딱 1개인 인터페이스라는 표시입니다.
 * 이런 인터페이스는 클래스를 만들지 않고 람다로도 구현할 수 있습니다.</p>
 * <pre>{@code
 * PaymentStrategy pointPay = amount -> System.out.println(amount + " 포인트 차감");
 * }</pre>
 *
 * @see CardPaymentStrategy
 * @see KakaoPayStrategy
 * @see CashPaymentStrategy
 * @see ShoppingCartStrategy#checkout(PaymentStrategy)
 */
@FunctionalInterface
public interface PaymentStrategy {

    /**
     * 주어진 금액을 결제합니다.
     *
     * @param amount 결제할 금액 (원)
     */
    void pay(int amount);
}
