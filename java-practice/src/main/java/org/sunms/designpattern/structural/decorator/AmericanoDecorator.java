package org.sunms.designpattern.structural.decorator;

/**
 * 토핑 없는 기본 아메리카노입니다. 가장 안쪽에 들어가는 "알맹이"입니다.
 *
 * <p><b>역할:</b> Concrete Component (포장될 알맹이)</p>
 *
 * @see BeverageDecorator
 */
public class AmericanoDecorator implements BeverageDecorator {

    /**
     * {@inheritDoc}
     *
     * @return "아메리카노"
     */
    @Override
    public String getDescription() {
        return "아메리카노";
    }

    /**
     * {@inheritDoc}
     *
     * @return 4000
     */
    @Override
    public int getCost() {
        return 4000;
    }
}
