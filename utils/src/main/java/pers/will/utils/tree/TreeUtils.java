package pers.will.utils.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * All rights Reserved,Designed by will
 *
 * @author will
 * @date 2019/9/23 22:53
 */
public class TreeUtils {

  /**
   * 根据父节点id生成树形结构(生成的是不包含父节点的森林)
   */
  public static <T extends BaseTreeObj, ID extends Serializable> List<T> genForestWithParentId(List<T> list, ID parentId) {
    Map<Serializable, List<T>> cachedMap = getCachedMap(list);
    List<T> subChildList = new ArrayList<>();
    for (T t : list) {
      if (Objects.equals(t.getParentId(t), parentId)) {
        recursionFn(cachedMap, t);
        subChildList.add(t);
      }
    }
    if ((subChildList.size() > 0)) {
      //排序节点的childList
      subChildList.sort(Comparator.comparing(t -> t.getOrder(t)));
    }
    return subChildList;
  }

  /**
   * 根据父节点生成包含该节点的树形结构
   */
  public static <T extends BaseTreeObj> List<T> genTreeWithNode(List<T> list, T rootNode) {
    Map<Serializable, List<T>> cachedMap = getCachedMap(list);
    List<T> subChildList = new ArrayList<>();
    for (T t : list) {
      if (Objects.equals(t.getParentId(t), rootNode.getId(rootNode))) {
        recursionFn(cachedMap, t);
        subChildList.add(t);
      }
    }
    if ((subChildList.size() > 0)) {
      //排序节点的childList
      subChildList.sort(Comparator.comparing(t -> t.getOrder(t)));
    }
    rootNode.setChildList(subChildList);
    return new ArrayList() {{
      add(rootNode);
    }};
  }

  /**
   * 递归构造某个节点的树形归档
   */
  private static <T extends BaseTreeObj, ID extends Serializable> void recursionFn(Map<Serializable, List<T>> map, T node) {
    List<T> childList = map.get(node.getId(node));
    node.setChildList(childList);
    if (childList.size() == 0) {
      return;
    }
    //排序节点的childList
    childList.sort(Comparator.comparing(t -> t.getOrder(t)));
    for (T t : childList) {
      recursionFn(map, t);
    }


  }

  /**
   * 获取子节点集合map
   */
  private static <T extends BaseTreeObj> Map<Serializable, List<T>> getCachedMap(List<T> list) {
    HashMap<Serializable, List<T>> childListMap = new HashMap<>();
    //初始化映射map
    for (T t : list) {
      if (!childListMap.containsKey(t.getId(t))) {
        childListMap.put(t.getId(t), new ArrayList<>());
      }
    }
    //遍历添加子节点集合
    for (T t : list) {
      if (childListMap.containsKey(t.getParentId(t))) {
        List<T> childList = childListMap.get(t.getParentId(t));
        childList.add(t);
      }
    }
    return childListMap;
  }

}

