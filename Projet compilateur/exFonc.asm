    
    ;ouvbloc 0
    enter 0,0
    
    ;ouvbloc 6
    enter 6,0
    
    ;istore-6
    pop ax
    mov word ptr[bp-6],ax
    SI1:
    
    ;iload-6
    push word ptr[bp-6]
    
    ;isup
    pop bx
    pop ax
    cmp ax,bx
    jle $+6
    push -1
    jmp $+4
    push 0
    
    ;iffaux SINON1
    pop ax
    cmp ax, 0
    je SINON1
    
    ;iload-6
    push word ptr[bp-6]
    
    ;gotoYVMFSI1
    jmp FSI1
    SINON1:
    FSI1:
    
    ;fermebloc 4
    leave
    ret 4
    
    ;ouvbloc 0
    enter 0,0
    
    ;ouvbloc 0
    enter 0,0
    SI1:
    
    ;iinf
    pop bx
    pop ax
    cmp ax,bx
    jge $+6
    push -1
    jmp $+4
    push 0
    
    ;iffaux SINON1
    pop ax
    cmp ax, 0
    je SINON1
    
    ;gotoYVMFSI1
    jmp FSI1
    SINON1:
    FSI1:
    
    ;fermebloc 4
    leave
    ret 4
    
    ;ouvbloc 0
    enter 0,0
    
    ;ouvbloc 0
    enter 0,0
    
    ;isup
    pop bx
    pop ax
    cmp ax,bx
    jle $+6
    push -1
    jmp $+4
    push 0
    
    ;fermebloc 4
    leave
    ret 4
    
    ;entete
    extrn lirent:proc,ecrent:proc
    extrn ecrbool:proc
    extrn ecrch:proc,ligsuiv:proc
debut:
STARTUPCODE
.model SMALL
.586
.CODE
debut:
STARTUPCODE
    
    ;ouvrePrinc 8
    mov bp,sp
    sub sp,8
    
    ;iconst 5
    push 5
    
    ;istore-2
    pop ax
    mov word ptr[bp-2],ax

;     lireEnt -4
lea dx,[bp-4]
push dx
call lirent

;     aLaLigne
call ligsuiv
    
    ;reserveRetour
    sub sp,2
    
    ;iload-2
    push word ptr[bp-2]
    
    ;reserveRetour
    sub sp,2
    
    ;iload-4
    push word ptr[bp-4]
    
    ;iconst 5
    push 5
