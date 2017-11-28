package com.mergeKLists;

import java.util.LinkedList;
import java.util.List;

class Node{
	int data;
	Node next;
	Node(int val){
		this.data = val;
		this.next = null;
	}
}

public class MergeKSortedLinkedLists {
	
    public List<Node> mergeKSortedLL(List<List<Node>> lists){

      List<Node> subres = new LinkedList<>();

      if(lists.size() == 0) return null;

      int last = lists.size() - 1;
      while(last != 0){
        int i = 0;

        while(i < last){
          subres = mergeTwoLL(lists.get(i), lists.get(last));
          lists.set(i, subres);
          i++;
          last--;

          if(i >= last)
            last = i;
        }
      }
      return lists.get(0);
    }

    public List<Node> mergeTwoLL(List<Node> l1, List<Node> l2){

      List<Node> res = new LinkedList<>();
      if(l1 == null) return l2;
      if(l2 == null) return l1;

      Node dummy = new Node(0);
      Node p = dummy;

      int i = 0, j = 0;

      while(l1.get(i) != null && l2.get(j) != null){
        if(l1.get(i).data < l2.get(i).data){
          p.next = l1.get(i);
          l1.get(i).next = l1.get(i++);
        } else {
          p.next = l2.get(i);
          l2.get(j).next = l2.get(j++);
        }
        p = p.next;
      }

      while(l1.get(i) != null){
        p.next = l1.get(i);
        l1.get(i).next = l1.get(i++);
        p = p.next;
      }

      while(l2.get(j) != null){
        p.next = l2.get(j);
        l2.get(j).next = l2.get(j++);
        p = p.next;
      }

      dummy = dummy.next;
      while(dummy.next != null){
        res.add(dummy);
      }
      return res;
    }
	}
