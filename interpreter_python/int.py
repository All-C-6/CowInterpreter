import numpy as np

#обработка файла и инициализация переменных (из файла удалены символы переноса строки)
file = open('Hello.txt', 'r')
f = file.read().split(' ')
stack = []
dict = {}
ind = 0
cells = np.zeros(len(f))
i = 0
index = 0

#обработка MOO и moo
for item in f:
    if item == 'MOO':
        stack.append(ind)
        print(stack)
    if item == 'moo':
        dict[ind] = stack[len(stack) - 1]
        dict[stack.pop()] = ind
        print(stack)
    ind += 1
print(f[11], f[136])
#интерпретирование (можно было сделать через match f[i] case "", но это только в питоне 3.10, я не знаю, какой у вас)
while(i < len(f)):
    if f[i] == 'MoO':
        cells[index] += 1

    if f[i] == 'MOo':
        cells[index] -= 1

    if f[i] == 'moO':
        index += 1

    if f[i] == 'mOo':
        index -= 1

    if f[i] == 'OOM':
        print(chr(int(cells[index])))

    if f[i] == 'Moo':
        if f[index] != 0:
            print(chr(int(cells[index])))

    if f[i] == 'OOO':
        f[index] = 0

    if f[i] == 'moo':
        i = dict[i] - 1

    if f[i] == 'MOO':
        if cells[index] == 0:
            i = dict[i]
    else:
        i += 1
        continue

    i += 1
