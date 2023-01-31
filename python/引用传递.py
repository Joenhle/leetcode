class People(object):
    def __init__(self, age):
        self.age = age

def get_people(p):
    print(id(p))
    p = People(10)
    print(id(p))

p = None
print(id(p))
get_people(p)
print(id(p))
print(p)