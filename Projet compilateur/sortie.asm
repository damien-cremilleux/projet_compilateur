
;entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

;ouvrePrinc 6
mov bp,sp
sub sp,6

;istore
pop ax
move word ptr[bp-2,ax]

;iconst
push 0

;istore
pop ax
move word ptr[bp-4,ax]

;iconst
push 2

;istore
pop ax
move word ptr[bp-2,ax]

;iload
push word ptr[bp-2]

;iconst
push 5

;iconst
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

;iload
push word ptr[bp-4]

;isub
pop bx
pop ax
sub ax,bx
push ax

;queue
nop
EXIT CODE
end debut
