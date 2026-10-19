package org.sunms.designpattern.creational.prototype;

/**
 * "나는 나 자신을 복사해서 새 객체를 만들어 줄 수 있다"는 약속입니다.
 *
 * <p><b>역할:</b> Prototype ("복사할 수 있다"는 규격)<br>
 * 패턴 전체 설명은 {@link MainPrototype#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <p>복사를 요청하는 쪽이 "어떤 종류의 문서인지" 몰라도 복사할 수 있게 하기 위해서입니다.</p>
 * <pre>{@code
 * DocumentPrototype doc = ...;      // 보고서든, 계약서든, 회의록이든
 * DocumentPrototype copy = doc.copy();
 * }</pre>
 * <p>→ 보고서, 계약서처럼 문서 종류가 늘어나도 복사하는 코드는 그대로입니다.</p>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>"어떻게 복사해야 하는지"는 그 객체 자신만 정확히 압니다.
 * (어떤 필드가 있는지, 어떤 리스트를 깊은 복사해야 하는지는 {@code private}이라 바깥에서 모름)<br>
 * 인터페이스가 없으면 바깥에서 문서 종류마다 if 문으로 필드를 하나하나 꺼내 복사해야 합니다.</p>
 * <pre>{@code
 * if (doc instanceof Report r) { new Report(r.getTitle(), ...) }
 * else if (doc instanceof Contract c) { ... }
 * }</pre>
 * <p>→ {@code copy()}를 규격으로 정해 두면 "복사 방법"을 각 클래스 안에 숨길 수 있습니다. (캡슐화)</p>
 *
 * @see ReportDocumentPrototype
 */
public interface DocumentPrototype {

    /**
     * 나와 똑같은 새 객체를 만들어 반환합니다.
     *
     * @return 복사된 새 문서 (원본과 독립적인 객체)
     */
    DocumentPrototype copy();
}
