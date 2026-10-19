package org.sunms.designpattern.behavioral.state;

/**
 * 자판기의 "품절" 상태입니다.
 * 이 상태에서는 아무것도 팔 수 없습니다. 동전을 넣으면 그대로 돌려줍니다.
 * (재고를 채우면 → 자판기가 "동전 없음" 상태로 전환)
 *
 * <p><b>역할:</b> Concrete State (상태 ③)</p>
 */
public class SoldOutState implements VendingMachineState {

    /**
     * 품절이므로 동전을 그대로 돌려줍니다.
     *
     * @param machine 이 상태를 가진 자판기
     */
    @Override
    public void insertCoin(VendingMachineContextState machine) {
        System.out.println("    품절입니다. 동전을 그대로 돌려드립니다.");
    }

    /**
     * 품절이므로 음료를 줄 수 없습니다.
     *
     * @param machine 이 상태를 가진 자판기
     */
    @Override
    public void selectDrink(VendingMachineContextState machine) {
        System.out.println("    품절입니다.");
    }

    /**
     * 반환할 동전이 없습니다.
     *
     * @param machine 이 상태를 가진 자판기
     */
    @Override
    public void returnCoin(VendingMachineContextState machine) {
        System.out.println("    반환할 동전이 없습니다.");
    }

    /**
     * {@inheritDoc}
     *
     * @return "품절"
     */
    @Override
    public String getName() {
        return "품절";
    }
}
