
;entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

;ouvrePrinc 6
mov bp,sp
sub sp,6

;  lireEnt -2
lea dx,[bp-2]
push dx
call lirent

; aLaLigne
call ligsuiv

;  lireEnt -4
lea dx,[bp-4]
push dx
call lirent

; aLaLigne
call ligsuiv
 
 ;iload-4
 push word ptr[bp-4]
 
 ;istore-6
 pop ax
 mov word ptr[bp-6],ax
SI1:
 
 ;iload-2
 push word ptr[bp-2]
 
 ;iload-4
 push word ptr[bp-4]
 
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
 
 ;iload-2
 push word ptr[bp-2]
 
 ;istore-6
 pop ax
 mov word ptr[bp-6],ax
 
 ;gotoYVMFSI1
 jmp FSI1
SINON1:
FSI1:
 
 ;iload-6
 push word ptr[bp-6]

;ecrireEnt
call ecrent

;queue
nop
EXITCODE
end debut
