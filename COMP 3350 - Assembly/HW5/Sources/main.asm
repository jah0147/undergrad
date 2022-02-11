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

RAMStart    EQU  $0800 
ROMStart    EQU  $4000  ; absolute address to place my code/constant data

; variable/data section

            ORG RAMStart

samples     DC.B    $10,$D0,$20,$E0,$B0,$50
nsum        DC.W    0
psum        DC.W    0
sqsum       DC.W    0


            ORG   ROMStart

Entry:
_Startup:
          
            ldx     #samples      ;loads x with value at samples      
            ldaa    #0
            
loop: 
            cmpa    #6            ;compairs a with 6 to check if the loop should keep going
            beq     squareSum
            
            ldab    0,x           ;loads b with value at x

            inca                   ;increments a by 1 
            cmpb    #0             ;compairs b with zero, if higher will go to positiv banch, if lower goes to negative
            blt     negativeSum    ;goes to negative branch if lower than zero
            bgt     positiveSum    ;goes to positive branch if greater than zero
           
positiveSum:            
            ldy     psum           ;loads y with value at psum
            aby                    ;adds b to y
            sty     psum           ;stores newly added value into psum
            inx                    ;increments x by 1
            bra     loop           ;goes back to loop branch
            
negativeSum:
            ldy     nsum           ;loads y with value at nsum
            aby                    ;adds b to y
            sty     nsum           ;stores newly added value
            inx                    ;increments x by 1
            bra     loop           ;goes back to loop branch
            

squareSum:  
            ldd   psum             ;loads d with psum 
            ldy   psum             ;loads y with psum
            emuls                  ;multiplies d and y with signed value
            
            std   sqsum            ;stores d into sqsum
            
            ldd   nsum             ;loads d with nsum
            ldy   nsum             ;loads y with nsum
            emuls                  ;multiplies d with y with signed values
            
            addd   sqsum           ;adds d with sqsum
            
            std   sqsum            ;stores new value of d in squm
            
            bra    done            ;goes to done branch
                     
            
done:
            rts                   ; result in D

;**************************************************************
;*                 Interrupt Vectors                          *
;**************************************************************
            ORG   $FFFE
            DC.W  Entry           ; Reset Vector
