print('🦁 아기 사자 명단 관리 프로그램입니다.')
name_list = []
while True:
    name = input('✏️  아기 사자 이름을 입력하세요 (종료하려면 q 입력): ')

    if name == 'q':
        print()
        print('📌 이름 입력을 종료합니다.')
        break

    if name == '':
        print('⚠️  이름이 비어있습니다. 다시 입력해주세요.')

    else:
        name_list.append(name)
        print(f'✅ {name} 이(가) 등록되었습니다.')

print()
print('📋 현재 아기 사자 명단입니다.')


num = len(name_list)
for i in range(num):
    print(f'🦁 {i + 1}. {name_list[i]}')