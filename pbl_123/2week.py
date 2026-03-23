# dict 구조로 아기사자 정보 관리

        
def search_by_track(lion):
    search_track = input('조회할 트랙을 입력하세요: ')
        
    found = False
        
    for i in lion:
        if i["트랙"] == search_track:
            print(f'- {i["이름"]} ({i["기수"]}기)')
        
            found = True
            
    if not found:
        print("해당 트랙에 아기사자가 없습니다.")
        
        
lion = []

while True:
    print('\n기능을 선택하세요\n1. 아기사자 등록\n2. 이름으로 검색\n3. 트랙으로 조회\n4. 종료')

    num = input('선택: ')

    #1.등록
    if num == '1':
        name = input('이름을 입력하세요: ')
        track = input('트랙을 입력하세요: ')
        lion_num = input('기수를 입력하세요: ')
        
        lion.append({
            "이름":name,
            "트랙":track,
            "기수":lion_num
        })
        
        print('아기사자가 등록되었습니다.')

    #2. 이름 검색
    elif num == '2':

        search_name = input('검색할 이름을 입력하세요: ')
        found = False
        
        for l in lion:
            if l["이름"] == search_name:
                print(f'이름: {l["이름"]}')
                print(f'트랙: {l["트랙"]}')
                print(f'기수: {l["기수"]}')
                found = True
        if not found:
            print("해당 이름이 존재하지 않습니다.")
        
                
                
                
    # 3. 트랙으로 조회           
    elif num == '3': 
        search_by_track(lion)
        
        
        
    elif num == '4':
        print('프로그램을 종료합니다.')
        break
    
    else:
        print('올바른 번호를 입력하세요')
        
