
;entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

;ouvrePrinc 4
mov bp,sp
sub sp,4

;iconst 0
push 0

;istore-4
pop ax
mov word ptr[bp-4],ax

;iload-4
push word ptr[bp-4]

;inot
pop ax
not ax
push ax

;istore-2
pop ax
mov word ptr[bp-2],ax

;iconst 10
push 10

;istore-2
pop ax
mov word ptr[bp-2],ax

;queue
nop
EXITCODE
end debut
