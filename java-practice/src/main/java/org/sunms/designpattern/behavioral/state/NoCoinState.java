package org.sunms.designpattern.behavioral.state;

/**
 * 자판기의 "동전 없음" 상태입니다.
 * 이 상태에서 할 수 있는 일: 동전 넣기 → "동전 있음" 상태로 전환
 *
 * <p><b>역할:</b> Concrete State (상태 ①)</p>
 */
public class NoCoinState implements VendingMachineState {

    /**
     * 동전을 받고 "동전 있음" 상태로 전환합니다. (상태 전환을 상태 객체가 직접!)
     *
     * @param machine 이 상태를 가진 자판기
     */
    @Override
    public void insertCoin(VendingMachineContextState machine) {
        System.out.println("    동전이 들어갔습니다.");
        machine.setState(new HasCoinState());
    }

    /**
     * 동전이 없으므로 음료를 줄 수 없습니다.
     *
     * @param machine 이 상태를 가진 자판기
     */
    @Override
    public void selectDrink(VendingMachineContextState machine) {
        System.out.println("    동전을 먼저 넣어 주세요.");
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
     * @return "동전 없음"
     */
    @Override
    public String getName() {
        return "동전 없음";
    }
}
