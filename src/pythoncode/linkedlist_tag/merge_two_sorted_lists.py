import leetcode_util
from listnode import ListNode


class MergeTwoLists:

    def mergeTwoLists(self, l1, l2):
        temp = ListNode(0)
        head = temp
        while l1 is not None and l2 is not None:
            if l1.val <= l2.val:
                temp.next = ListNode(l1.val)
                l1 = l1.next
            else:
                temp.next = ListNode(l2.val)
                l2 = l2.next
            temp = temp.next
        while l1 is not None:
            temp.next = ListNode(l1.val)
            l1 = l1.next
            temp = temp.next
        while l2 is not None:
            temp.next = ListNode(l2.val)
            l2 = l2.next
            temp = temp.next

        return head.next

if __name__ == '__main__':
    mtl = MergeTwoLists()
    array1 = [0,1]
    array2 = [1,1,3]
    l1 = leetcode_util.array_to_listnode(array1)
    l2 = leetcode_util.array_to_listnode(array2)
    newlist = mtl.mergeTwoLists(l1,l2)
    leetcode_util.print_listnode(newlist)
