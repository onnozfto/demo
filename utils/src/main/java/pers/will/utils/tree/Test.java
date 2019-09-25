package pers.will.utils.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved,Designed by will
 *
 * @author will
 * @date 2019/9/23 22:29
 */
public class Test {

  public static void main(String[] args) {
    List<Node> list = new ArrayList<>();

    list.add(genNode(6, null, 1));
    list.add(genNode(7, 6, 2));
    list.add(genNode(100, 6, 1));
    list.add(genNode(102, 6, 3));
    list.add(genNode(101, 6, 8));
    list.add(genNode(103, 6, 9));
    list.add(genNode(999, null, 1));
    for (int i = 1000; i < 1200; i++) {
      list.add(genNode(i, i - 1, 1));
    }

    long end = System.nanoTime();
    List<Node> nodes1 = TreeUtils.genForestWithParentId(list, null);
    List<Node> ll = TreeUtils.genTreeWithNode(list, list.get(0));
    System.out.println("=========" + (System.nanoTime() - end));
  }

  private static Node genNode(int id, Integer parentId, Integer order) {
    Node node = new Node();
    node.setId(id);
    node.setParentId(parentId);
    node.setOrder(order);
    return node;
  }
}
