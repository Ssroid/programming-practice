package org.sunms.designpattern.behavioral.state;

/**
 * 자판기입니다.
 *
 * <p><b>역할:</b> Context (상태를 가진 주인공)</p>
 *
 * <h2>핵심 포인트</h2>
 * <p>{@link #insertCoin()}, {@link #selectDrink()}, {@link #returnCoin()} 안에 if 문이 하나도 없습니다!
 * 그냥 "현재 상태 객체"에게 일을 넘길 뿐입니다. (위임)<br>
 * → 상태가 바뀌면({@code state} 필드가 다른 객체로 교체되면) 같은 메서드도 다르게 동작합니다.</p>
 *
 * @see VendingMachineState
 */
public class VendingMachineContextState {

    /** 현재 상태 */
    private VendingMachineState state;
    /** 음료 재고 */
    private int stock;

    /**
     * 자판기를 만듭니다.
     * 시작 상태는 재고가 있으면 "동전 없음", 없으면 "품절"입니다.
     *
     * @param stock 처음 넣어 둘 음료 재고
     */
    public VendingMachineContextState(int stock) {
        this.stock = stock;
        this.state = (stock > 0) ? new NoCoinState() : new SoldOutState();
    }

    /**
     * 동전을 넣습니다. 현재 상태에게 위임합니다.
     */
    public void insertCoin() {
        System.out.println("  [동전 투입] (현재 상태: " + state.getName() + ")");
        state.insertCoin(this);    // this = 자판기 자신을 넘겨서, 상태가 자판기를 조작할 수 있게
    }

    /**
     * 음료 버튼을 누릅니다. 현재 상태에게 위임합니다.
     */
    public void selectDrink() {
        System.out.println("  [음료 선택] (현재 상태: " + state.getName() + ")");
        state.selectDrink(this);
    }

    /**
     * 반환 레버를 당깁니다. 현재 상태에게 위임합니다.
     */
    public void returnCoin() {
        System.out.println("  [동전 반환] (현재 상태: " + state.getName() + ")");
        state.returnCoin(this);
    }

    /**
     * 관리자가 재고를 채웁니다. 채운 뒤에는 "동전 없음" 상태가 됩니다.
     *
     * @param count 보충할 음료 개수
     */
    public void refill(int count) {
        stock += count;
        System.out.println("  [관리자] 재고 " + count + "개 보충 (재고: " + stock + ")");
        setState(new NoCoinState());
    }

    /**
     * 상태를 바꿉니다. (상태 객체들이 사용)
     *
     * @param newState 새 상태
     */
    void setState(VendingMachineState newState) {
        System.out.println("    (상태 변경: " + state.getName() + " → " + newState.getName() + ")");
        this.state = newState;
    }

    /**
     * 음료를 하나 내보내고 재고를 1 줄입니다. (상태 객체들이 사용)
     */
    void releaseDrink() {
        stock--;
        System.out.println("    음료가 나왔습니다! 덜컹 (남은 재고: " + stock + ")");
    }

    /**
     * 남은 재고를 알려줍니다. (상태 객체들이 사용)
     *
     * @return 남은 음료 개수
     */
    int getStock() {
        return stock;
    }
}
