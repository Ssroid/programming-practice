package org.sunms.designpattern.behavioral.templatemethod;

/**
 * 커피입니다. 순서는 신경 쓰지 않고, "다른 단계"만 채우면 됩니다.
 *
 * <p><b>역할:</b> Concrete Class (구체 클래스)</p>
 *
 * <p>훅 활용: 블랙커피를 원하면 첨가물 단계를 건너뜁니다.</p>
 */
public class CoffeeTemplateMethod extends BeverageTemplateMethod {

    /** {@code true}면 블랙커피 (설탕/우유 X) */
    private final boolean black;

    /**
     * 커피를 만듭니다.
     *
     * @param black 블랙커피면 {@code true}
     */
    public CoffeeTemplateMethod(boolean black) {
        this.black = black;
    }

    /**
     * {@inheritDoc}
     *
     * @return "블랙커피" 또는 "커피"
     */
    @Override
    protected String getName() {
        return black ? "블랙커피" : "커피";
    }

    /**
     * 필터로 커피를 우려냅니다.
     */
    @Override
    protected void brew() {
        System.out.println("  2) 필터로 커피를 우려냅니다.");
    }

    /**
     * 설탕과 우유를 추가합니다.
     */
    @Override
    protected void addCondiments() {
        System.out.println("  4) 설탕과 우유를 추가합니다.");
    }

    /**
     * 훅 재정의: 블랙커피면 첨가물 단계를 건너뜁니다.
     *
     * @return 블랙커피가 아닐 때만 {@code true}
     */
    @Override
    protected boolean customerWantsCondiments() {
        return !black;
    }
}
