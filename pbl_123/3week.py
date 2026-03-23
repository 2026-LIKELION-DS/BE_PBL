class Member:
    def __init__(self, name):
        if name.strip()=="":
            print('잘못된 이름입니다.')
        self.name=name



class Lion(Member):
    def __init__(self, name, track, lion_num):
        super().__init__(name)
        self.track = track
        self.lion_num = lion_num
        
    def get_info(self):
        print(f'아기사자 : {self.name} | {self.track} | {self.lion_num}')

        
class Staff(Member):
    def __init__(self, name):
        super().__init__(name)
        
    def get_info(self):
        print(f'운영진 : {self.name}')



class Printer:
    def print_member(self, member):
        print(member)

    
members=[]
printer = Printer()

while True:
    print('📌 기능을 선택하세요\n1️⃣  아기사자 등록\n2️⃣  운영진 등록\n3️⃣  전체 출력\n4️⃣  종료')
    
    num = input('선택: ')
    
    if num =='1':
        name = input('이름: ')
        
        if name.strip()=="":
            print('이름이 공백입니다. 다시 입력해주십시오.')
            continue
        track = input('트랙: ')
        lion_num = input('기수: ')
        
        new_lion = Lion(name, track, lion_num)
        members.append(new_lion)
        
        print('✅ 아기사자가 등록되었습니다.')
        
    elif num =='2':
        name = input('이름: ')
        staff = Staff(name)
        members.append(staff)
        
        print('✅ 운영진이 등록되었습니다.')
        
    elif num =='3':
        print('📋 멤버 목록')
        if not members:
            print('등록된 멤버가 없습니다.')
        else:
            for member in members:
                member.get_info()
                
                
    elif num =='4':
        print('👋 프로그램을 종료합니다.')
        break
    else:
        print('올바른 번호를 입력해주세요.')
    
    