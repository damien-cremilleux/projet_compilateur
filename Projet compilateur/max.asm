
;entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

;ouvrePrinc 2
mov bp,sp
sub sp,2

;iconst 10
push 10

;istore-2
pop ax
mov word ptr[bp-2],ax

;queue
nop
EXITCODE
end debut
