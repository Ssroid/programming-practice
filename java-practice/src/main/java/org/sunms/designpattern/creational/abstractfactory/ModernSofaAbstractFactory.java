package org.sunms.designpattern.creational.abstractfactory;

/**
 * 모던 스타일 세트의 "소파"입니다.
 *
 * <p><b>역할:</b> Concrete Product (구체적인 제품)</p>
 *
 * @see ModernFurnitureAbstractFactory
 */
public class ModernSofaAbstractFactory implements SofaAbstractFactory {

    /**
     * 각진 회색 패브릭 소파에 눕습니다.
     */
    @Override
    public void lieOn() {
        System.out.println("  [모던 소파] 각진 회색 패브릭 소파에 누웠습니다.");
    }
}
