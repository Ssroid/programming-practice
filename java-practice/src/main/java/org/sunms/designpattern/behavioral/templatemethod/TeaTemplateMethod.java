package org.sunms.designpattern.behavioral.templatemethod;

/**
 * 레몬 홍차입니다. 커피와 2단계, 4단계만 다르게 구현합니다.
 * (훅 메서드는 재정의하지 않음 → 부모의 기본값({@code true}) 사용)
 *
 * <p><b>역할:</b> Concrete Class (구체 클래스)</p>
 */
public class TeaTemplateMethod extends BeverageTemplateMethod {

    /**
     * {@inheritDoc}
     *
     * @return "레몬 홍차"
     */
    @Override
    protected String getName() {
        return "레몬 홍차";
    }

    /**
     * 찻잎을 3분간 우려냅니다.
     */
    @Override
    protected void brew() {
        System.out.println("  2) 찻잎을 3분간 우려냅니다.");
    }

    /**
     * 레몬 조각을 넣습니다.
     */
    @Override
    protected void addCondiments() {
        System.out.println("  4) 레몬 조각을 넣습니다.");
    }
}
