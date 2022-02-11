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
            ldaa       $800   ;gets data from memory adress 800
            ldab       $801   ;gets data from memory adress 801
            sba               ;subtracts value of b from a
            staa       $807   ;stores thee new value a
            
            ldx       $805
            stx       $808
            ldaa       ,x   ;loads value stored in m address 805 to a
            ldab      #$50
            sba
            staa       $808
            
            
            rts

            ;            ; result in D

;**************************************************************
;*                 Interrupt Vectors                          *
;**************************************************************
            ORG   $FFFE
            DC.W  Entry           ; Reset Vector
