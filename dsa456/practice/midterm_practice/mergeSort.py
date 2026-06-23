def merge_sort(mylist):
    empty_list = [0] * len(mylist) 
                                   

    recursive_merge_sort(mylist, 0, len(mylist) - 1, empty_list) 

def recursive_merge_sort(mylist, first_index, last_index, empty_list):
    if first_index < last_index:
        mid_index = (first_index + last_index) // 2
        recursive_merge_sort(mylist, first_index, mid_index, empty_list)
        recursive_merge_sort(mylist, mid_index + 1, last_index, empty_list)
        merge(mylist, first_index, mid_index + 1, last_index, empty_list)


def merge(mylist, a_first_index, b_first_index, b_last_index, empty_list):
    a_ptr = a_first_index
    b_ptr = b_first_index
    empty_list_index = a_ptr

    while (a_ptr < b_first_index) and (b_ptr <= b_last_index):
        if mylist[a_ptr] <= mylist[b_ptr]:
            empty_list[empty_list_index] = mylist[a_ptr]
            empty_list_index += 1
            a_ptr += 1
        else:
            empty_list[empty_list_index] = mylist[b_ptr]
            empty_list_index += 1
            b_ptr += 1

    while a_ptr < b_first_index:
        empty_list[empty_list_index] = mylist[a_ptr]
        empty_list_index += 1
        a_ptr += 1

    while b_ptr <= b_last_index:
        empty_list[empty_list_index] = mylist[b_ptr]
        empty_list_index += 1
        b_ptr += 1

    for i in range(a_first_index, b_last_index + 1):
        mylist[i] = empty_list[i]


# erase from list

def erase(self, pos):
    if self.head == pos:
        self.pop_front()
    elif self.tail == pos:
        self.pop_back()
    else:
        before = pos.prev
        after = pos.next
        pos.prev = None
        pos.next = None
        after.prev = before
        before.next = after


def erase2(self, pos):
    if self.head == pos:
        self.pop_front()
    elif self.tail == pos:
        self.pop_back()
    else:
        pos.prev.next = pos.next
        pos.next.prev = pos.prev
        pos.prev = None
        pos.next = None