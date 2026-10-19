package org.sunms.designpattern.behavioral.strategy;

/**
 * 신용카드 결제 전략입니다.
 *
 * <p><b>역할:</b> Concrete Strategy (구체적인 전략 ①)</p>
 */
public class CardPaymentStrategy implements PaymentStrategy {

    /** 카드 번호 */
    private final String cardNumber;

    /**
     * 카드 결제 전략을 만듭니다.
     *
     * @param cardNumber 카드 번호 (예: "1234-5678-9012-3456")
     */
    public CardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 카드로 결제합니다. 카드 번호는 뒤 4자리만 보여줍니다.
     *
     * @param amount 결제할 금액 (원)
     */
    @Override
    public void pay(int amount) {
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("  [카드 결제] ****-" + lastFour + " 카드로 " + amount + "원 결제 완료");
    }
}
