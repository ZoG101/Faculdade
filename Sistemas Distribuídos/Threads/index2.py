import _thread
import time

num_threads = 0
max_loop = 5
thread_iniciada = False

def atividade (nome_atividade, espera):
    global num_threads, max_loop, thread_iniciada
    thread_iniciada = True
    num_threads += 1
    contador = 0
    while contador < max_loop:
        time.sleep(espera)
        print("Thread : %s" %(nome_atividade))
        contador += 1
    num_threads -= 1

_thread.start_new_thread(atividade, ("Atividade 1", 10))
_thread.start_new_thread(atividade, ("Atividade 2", 5))

while not thread_iniciada:
    pass
while num_threads > 0:
    pass
