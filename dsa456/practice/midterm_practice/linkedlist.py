class SingleLinked:
    class Node:
        def __init__(self, data, next = None):
            self.data = data
            self.next = next

    def __init__(self):
        self.head = None
        self.tail = None

    def print_list(self):
        curr = self.head
        while curr != None:
            print(curr.data)
            curr = curr.next
    
    def push_front(self, data):
        nn = self.Node(data)
        if self.head == None:
            self.tail = nn
        else:
            nn.next = self.head
        self.head = nn
    
    def push_back(self, data):
        nn = self.Node(data)
        if self.tail == None:
            self.head = nn
        else:
            self.tail.next = nn
        self.tail = nn

    def insert_before(self, data, node):
        if node == self.head:
            self.push_front(data)
        else:
            nn = self.Node(data)
            curr = self.head
            while curr.next != node:
                curr = curr.next
            
            nn.next = curr.next
            curr.next = nn

    def insert_after(self, data, node):
        if node == self.tail:
            self.push_back(data)
        else:
            nn = self.Node(data)
            curr = self.head
            while curr != node:
                curr = curr.next
            
            nn.next = curr.next
            curr.next = nn
            
    def insert_after_value(self, data, target):
        curr = self.head
        while curr != None:
            if curr.data == target:
                break
            curr = curr.next
        
        if curr == None:
            return None
        
        nn = self.Node(data)
        nn.next = curr.next
        curr.next = nn
        if nn.next == None:
            self.tail = nn

    def delete_node(self, value):
        curr = self.head
        if curr.data == value:
            self.head = self.head.next
            return True
        while curr != None:
            if curr.next.data == value:
                break
            curr = curr.next
            
        if curr.next == None:
            return False
        elif curr.value == self.tail:
            self.tail = curr
        else:
            curr.next = curr.next.next
            curr.next.next = None

        

class DoubleLinked:
    class Node:
        def __init__(self, data, next = None, prev = None):
            self.data = data
            self.next = next
            self.prev = prev
    
    def __init__(self):
        self.head = None
        self.tail = None

class SingleLinkedSentinel:
    class Node:
        def __init__(self, data, next = None):
            self.data = data
            self.next = next
    def __init__(self):
        self.head = self.Node()
        self.tail = self.Node()
        self.head.next = self.tail

class DoubleLinkedSentinel:
    class Node:
        def __init__(self, data, next = None, prev = None):
            self.data = data
            self.next = next
            self.prev = prev
    def __init__(self):
        self.head = self.Node()
        self.tail = self.Node()
        self.head.next = self.tail
        self.tail.prev = self.head


        