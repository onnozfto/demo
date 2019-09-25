package pers.will.utils.tree;

import java.util.List;

/**
 * All rights Reserved,Designed by will
 *
 * @author will
 * @date 2019/9/23 22:31
 */
public class Node extends BaseTreeObj<Node, Integer, Integer> {

  private Integer id;

  private Integer parentId;

  private Integer order;

  private List<Node> subNode;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public List<Node> getSubNode() {
    return subNode;
  }

  public void setSubNode(List<Node> subNode) {
    this.subNode = subNode;
  }

  @Override
  public Integer getId(Node node) {
    return node.getId();
  }

  @Override
  public Integer getParentId(Node node) {
    return node.getParentId();
  }

  @Override
  public Integer getOrder(Node node) {
    return node.getOrder();
  }

  @Override
  public void setChildList(List<Node> childList) {
      this.subNode  = childList;
  }
}
