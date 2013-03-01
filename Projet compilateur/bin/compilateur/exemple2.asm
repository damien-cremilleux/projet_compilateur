
;entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

;ouvrePrinc 6
mov bp,sp
sub sp,6

;iconst 0
push 0

;istore-2
pop ax
mov word ptr[bp-2],ax

;iconst 2
push 2

;istore-4
pop ax
mov word ptr[bp-4],ax

;iload-2
push word ptr[bp-2]

;iconst 5
push 5

;iconst 10
push 10

;imul
pop bx
pop ax
imul bx
push ax

;iadd
pop bx
pop ax
add ax,bx
push ax

;iload-4
push word ptr[bp-4]

;isub
pop bx
pop ax
sub ax,bx
push ax

;istore-2
pop ax
mov word ptr[bp-2],ax

;queue
nop
EXITCODE
end debut
