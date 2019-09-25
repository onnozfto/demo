package pers.will.utils.tree;

import java.io.Serializable;
import java.util.List;


/**
 * All rights Reserved,Designed by will 抽象树形节点
 *
 * @param <E> 节点类型
 * @param <ID> 节点的Id类型
 * @param <O> 同层次节点的排序字段类型
 */
public abstract class BaseTreeObj<E extends BaseTreeObj, ID extends Serializable, O extends Comparable> implements Serializable {

  private static final long serialVersionUID = 1L;


  /**
   * 获取节点的id
   */
  public abstract ID getId(E e);

  /**
   * 获取节点的parentId
   */
  public abstract ID getParentId(E e);

  /**
   * 获取节点的排序序号
   */
  public abstract O getOrder(E e);

  /**
   * 设置节点的子节点
   */
  public abstract void setChildList(List<E> childList);


}
