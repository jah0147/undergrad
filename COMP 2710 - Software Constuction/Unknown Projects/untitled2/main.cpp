;*****************************************************************
;* This stationery serves as the framework for a                 *
;* user application (single file, absolute assembly application) *
;* For a more comprehensive program that                         *
;* demonstrates the more advanced functionality of this          *
;* processor, please see the demonstration applications          *
;* located in the examples subdirectory of the                   *
;* Freescale CodeWarrior for the HC12 Program directory          *
;*****************************************************************

; export symbols
XDEF Entry, _Startup            ; export 'Entry' symbol
        ABSENTRY Entry        ; for absolute assembly: mark this as application entry point



; Include derivative-specific definitions
;INCLUDE 'derivative.inc'
RAMStart    EQU  $0800
        ROMStart    EQU  $4000  ; absolute address to place my code/constant data


ORG       RAMStart
Sarray      DC.B      $E0,$C0,$A0,$80,$60,$40,$20
Darray      DS.B      7

ORG       ROMStart


Entry:
_Startup:
ldaa       $806     ;gets last value from Sarray (at M 806)
staa       Darray   ;stores a into the first value of Darray

ldx        #$804    ;sets x to value 804
ldaa       $1,x     ;loads a with M value of 804+1, so the value stored in 805
staa       +4,x     ;stores a value in memory location x (which is 804) +4, so stores in location 808

ldx        #$800    ;loads x with value 800
ldab       #$4      ;loads b with value 4
ldaa       b,x      ;adds x and b together to get 804 (we want the value in M:804 so we can store it in M:809)
staa       +9,x     ;stores value a in the M location of x (whch is 900) +9, so location 809
staa     


;***********************************************************************
rts     ;end statement

;**************************************************************
;*                 Interrupt Vectors                          *
;**************************************************************
ORG   $FFFE
DC.W  Entry           ; Reset Vector
