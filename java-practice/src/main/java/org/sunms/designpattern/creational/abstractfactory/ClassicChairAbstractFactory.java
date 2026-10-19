package org.sunms.designpattern.creational.abstractfactory;

/**
 * 클래식 스타일 세트의 "의자"입니다.
 *
 * <p><b>역할:</b> Concrete Product (구체적인 제품)</p>
 *
 * @see ClassicFurnitureAbstractFactory
 */
public class ClassicChairAbstractFactory implements ChairAbstractFactory {

    /**
     * 조각 장식이 들어간 원목 의자에 앉습니다.
     */
    @Override
    public void sitOn() {
        System.out.println("  [클래식 의자] 조각 장식이 들어간 원목 의자에 앉았습니다.");
    }
}
