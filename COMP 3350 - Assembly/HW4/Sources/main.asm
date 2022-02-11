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
            ldaa   #800
            ldaa $800
            
;***********************************************************************            
            rts     ;end statement

;**************************************************************
;*                 Interrupt Vectors                          *
;**************************************************************
            ORG   $FFFE
            DC.W  Entry           ; Reset Vector
