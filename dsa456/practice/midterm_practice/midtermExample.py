
def strToInt(str):
    if len(str) == 1:
        return ord(str[0])
    
    return ord(str[0]) * (10**(len(str) - 1)) + strToInt(str[1:])

# "1234"
# 1234


class SelfAdjustingList:
    class Node:
        def __init__(self, dat, nx, pr):
            self.data = dat
            self.next = nx
            self.prev = pr
    
    def __init__(self):
        self.front = None
        self.back = None

    def search(self, v):
        target = self.front
        while target != None:
            if target.data == v:
                   break
            target = target.next
        if target == None or target.data != v:
            return False
        elif target == self.front:
            return True
        elif target == self.back:
            self.back = self.back.prev
            self.back.next = None
        else:
            target.prev.next = target.next
            target.next.prev = target.prev
        
        target.prev = None
        self.front.prev = target
        target.next = self.front
        self.front = target

class SelfAdjustingListSentinel:
    class Node:
        def __init__(self, data, nx = None, pr = None):
            self.data = data
            self.next = nx
            self.prev = pr
    
    def __init__(self):
        self.head = self.Node()
        self.tail = self.Node()
        self.head.next = self.tail
        self.head.prev = None
        self.tail.prev = self.head
        self.tail.next = None


    def search(self, v):
        target = self.head.next
        while target != self.tail:
            if target.data == v:
                   break
            target = target.next
        if target == self.tail or target.data != v:
            return False
        elif target == self.head.next:
            return True
        elif target == self.tail.prev:
            self.tail.prev = self.tail.prev.prev
            self.tail.prev.next = self.tail
        else:
            target.prev.next = target.next
            target.next.prev = target.prev
        
        target.prev = self.head
        target.next = self.head.next
        self.head.next.prev = target
        self.head.next = target
        return True   

def do_recursion(str, curr):
    if curr == len(str):
        return 0
    elif str[curr] == "a":
        return 1 + do_recursion(str, curr + 1)
    else:
        return do_recursion(str, curr + 1)

def do_something(str):
    return do_recursion(str, 0)



def revert(l):
    revert_rec(l, 0, len(l) - 1)
    return l

def revert_rec(l, start, end):
    if start >= end:
        return None
    temp = l[end]
    l[end] = l[start]
    l[start] = temp
    return revert_rec(l, start + 1, end - 1)