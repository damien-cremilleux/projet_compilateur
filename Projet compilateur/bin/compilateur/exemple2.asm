
;entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

;ouvrePrinc 10
mov bp,sp
sub sp,10

;iconst 10
push 10

;ineg
neg ax
push ax

;istore-2
pop ax
mov word ptr[bp-2],ax

;queue
nop
EXITCODE
end debut
