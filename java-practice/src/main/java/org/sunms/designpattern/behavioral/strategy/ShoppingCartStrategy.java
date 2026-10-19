package org.sunms.designpattern.behavioral.strategy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 장바구니입니다. 상품을 담고 결제합니다.
 *
 * <p><b>역할:</b> Context (전략을 사용하는 쪽)</p>
 *
 * <h2>핵심 포인트</h2>
 * <p>{@link #checkout(PaymentStrategy)} 메서드 안에 "카드", "카카오페이" 같은 단어가 하나도 없습니다!
 * 전달받은 전략({@link PaymentStrategy})에게 결제를 "위임"할 뿐입니다.<br>
 * → 새 결제 수단이 생겨도 이 클래스는 수정할 필요가 없습니다.</p>
 */
public class ShoppingCartStrategy {

    /** 담긴 상품 (상품명 → 가격). 담은 순서를 유지합니다. */
    private final Map<String, Integer> items = new LinkedHashMap<>();

    /**
     * 상품을 장바구니에 담습니다.
     *
     * @param name  상품명
     * @param price 가격 (원)
     */
    public void addItem(String name, int price) {
        items.put(name, price);
    }

    /**
     * 장바구니 합계 금액을 계산합니다.
     *
     * @return 합계 금액 (원)
     */
    public int getTotal() {
        int total = 0;
        for (int price : items.values()) {
            total += price;
        }
        return total;
    }

    /**
     * 전달받은 결제 전략으로 결제합니다.
     * 어떤 방식으로 결제할지는 전략이 알아서 처리합니다.
     *
     * @param strategy 사용할 결제 전략
     */
    public void checkout(PaymentStrategy strategy) {
        int total = getTotal();
        System.out.println("  장바구니: " + items + " / 합계 " + total + "원");
        strategy.pay(total);   // ★ 어떤 방식으로 결제할지는 전략이 알아서!
    }
}
