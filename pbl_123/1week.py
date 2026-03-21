print('아기 사자 명단 관리 프로그램입니다.')

def lion_func():
    lion = []
    while True:
        lion_input = input('아기사자 이름을 입력하세요(종료하려면 q 입력): ')
        
        # 입력값이 'q'인 경우 종료
        if lion_input.lower() == 'q':                
            print("프로그램을 종료합니다.")
            break
        elif lion_input.strip() == "":  # strip():앞뒤 공백 제거
            print('이름이 비어있습니다. 다시 입력해주세요')
        # 'q'가 아닐 때 수행할 동작
        else:
            lion.append(lion_input)
            
    return lion
      
        
lion_list = lion_func()
print('현재 아기 사자 명단입니다.')
for i,li in enumerate(lion_list, start=1):
    print(f'{i}.{li}')
        
