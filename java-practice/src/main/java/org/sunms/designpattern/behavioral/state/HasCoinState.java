package org.sunms.designpattern.behavioral.state;

/**
 * 자판기의 "동전 있음" 상태입니다.
 *
 * <p><b>역할:</b> Concrete State (상태 ②)</p>
 *
 * <p>이 상태에서 할 수 있는 일:</p>
 * <ul>
 *   <li>음료 선택 → 음료 배출 후, 재고에 따라 "동전 없음" 또는 "품절" 상태로 전환</li>
 *   <li>동전 반환 → "동전 없음" 상태로 전환</li>
 * </ul>
 */
public class HasCoinState implements VendingMachineState {

    /**
     * 이미 동전이 있으므로 더 받지 않습니다.
     *
     * @param machine 이 상태를 가진 자판기
     */
    @Override
    public void insertCoin(VendingMachineContextState machine) {
        System.out.println("    이미 동전이 들어 있습니다. (한 번에 하나만)");
    }

    /**
     * 음료를 내보내고, 남은 재고에 따라 다음 상태를 정합니다.
     *
     * @param machine 이 상태를 가진 자판기
     */
    @Override
    public void selectDrink(VendingMachineContextState machine) {
        machine.releaseDrink();                        // 음료 배출 (재고 -1)

        if (machine.getStock() > 0) {
            machine.setState(new NoCoinState());       // 재고가 남았으면 → 동전 없음
        } else {
            System.out.println("    마지막 음료였습니다!");
            machine.setState(new SoldOutState());      // 재고가 없으면 → 품절
        }
    }

    /**
     * 동전을 돌려주고 "동전 없음" 상태로 전환합니다.
     *
     * @param machine 이 상태를 가진 자판기
     */
    @Override
    public void returnCoin(VendingMachineContextState machine) {
        System.out.println("    동전을 돌려드립니다.");
        machine.setState(new NoCoinState());
    }

    /**
     * {@inheritDoc}
     *
     * @return "동전 있음"
     */
    @Override
    public String getName() {
        return "동전 있음";
    }
}
