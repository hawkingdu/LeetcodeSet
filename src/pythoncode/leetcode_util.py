
from listnode import ListNode


def array_to_listnode(array):
    if len(array) > 0:
        head = ListNode(array[0])
        temp = head
        for e in array[1:]:
            node = ListNode(e)
            temp.next = node
            temp = temp.next
        return head


def print_listnode(head):
    temp = head
    s = str()
    while temp is not None:
        s = s + repr(temp.val) + "->"
        temp = temp.next
    print(s + 'None')


if __name__ == '__main__':
    array = [1, 2, 3]
    head = array_to_listnode(array)
    print_listnode(head)
