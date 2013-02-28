
;entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

;ouvrePrinc 6
mov bp,sp
sub sp,6

;iconst
push 1

;istore
pop ax
move word ptr[bp-2,ax]

;iconst
push 2

;istore
pop ax
move word ptr[bp-4,ax]

;iload
push word ptr[bp-2]

;iload
push word ptr[bp-4]

;iadd
pop bx
pop ax
add ax,bx
push ax

;iconst
push 2

;idiv
pop bx
pop ax
cwd
idiv bx
push ax

;istore
pop ax
move word ptr[bp-4,ax]

;queue
nop
EXIT CODE
end debut
