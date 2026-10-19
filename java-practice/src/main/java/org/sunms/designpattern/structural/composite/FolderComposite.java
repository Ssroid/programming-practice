package org.sunms.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 폴더입니다. 파일과 폴더를 모두 담을 수 있습니다.
 *
 * <p><b>역할:</b> Composite (복합 객체, 그릇)</p>
 *
 * <h2>핵심 포인트</h2>
 * <p>{@code List<FileSystemItemComposite> children}</p>
 * <ul>
 *   <li>리스트 타입이 "인터페이스"라서 파일이든 폴더든 상관없이 담을 수 있음</li>
 *   <li>폴더 안에 폴더를 넣을 수 있으므로 깊이 제한 없는 트리가 만들어짐</li>
 * </ul>
 *
 * @see FileComposite
 */
public class FolderComposite implements FileSystemItemComposite {

    /** 폴더 이름 */
    private final String name;
    /** 폴더 안에 든 항목들 (파일 또는 폴더) */
    private final List<FileSystemItemComposite> children = new ArrayList<>();

    /**
     * 빈 폴더를 만듭니다.
     *
     * @param name 폴더 이름
     */
    public FolderComposite(String name) {
        this.name = name;
    }

    /**
     * 폴더에 파일 또는 폴더를 추가합니다.
     *
     * @param item 추가할 항목
     * @return 이 폴더 자신 (체이닝용)
     */
    public FolderComposite add(FileSystemItemComposite item) {
        children.add(item);
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @return 폴더 이름
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * ★ 재귀적으로 크기를 계산합니다.
     *
     * <ul>
     *   <li>자식에게 {@code getSize()}를 물어봄</li>
     *   <li>자식이 파일이면 → 파일 크기 반환</li>
     *   <li>자식이 폴더면 → 그 폴더가 또 자기 자식들에게 물어봄 (재귀)</li>
     *   <li>여기서는 자식이 파일인지 폴더인지 "구분하지 않습니다"! (이게 컴포지트의 힘)</li>
     * </ul>
     *
     * @return 폴더 안 모든 항목의 크기 합계 (KB)
     */
    @Override
    public int getSize() {
        int total = 0;
        for (FileSystemItemComposite child : children) {
            total += child.getSize();
        }
        return total;
    }

    /**
     * 폴더와 그 안의 모든 항목을 트리 모양으로 출력합니다.
     * 한 단계 깊어질수록 들여쓰기가 늘어납니다.
     *
     * @param indent 앞에 붙일 들여쓰기 문자열
     */
    @Override
    public void print(String indent) {
        System.out.println(indent + "[폴더] " + name + "/ (총 " + getSize() + "KB)");
        for (FileSystemItemComposite child : children) {
            child.print(indent + "    ");   // 한 단계 깊어질수록 들여쓰기 추가
        }
    }
}
