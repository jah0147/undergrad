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
            
            ldx        #$803    ;loads x with value 803
            ldaa       $7,x+    ;loads a with x plus 7, then x also changes, so x is now 80A 
            ldaa       $5,-x    ;looks at x first and subtracts 5 from x, then loads x into a, so a is now 805
            ldaa       $2,-x    ;looks at x first and subtracts 2 from x, then loads x into a, so a is now 803
            staa       $80A     ; we store a into M:80A
            
;Done with 4 required steps. Now will finish storing Sarray reversly into Darray
;   Process repeated for last 3 values

            ldx        #$802    ;loads x with value 802
            ldab       #$809    ;loads b with value 809 (bc we want to add b and x to store in M:80B) 
            ldaa       0,x      ;loads a with value of x (M:802) +0, which gives a a value of $A0
            staa       b,x      ;stores a in M:80B
            
            ldx        #$801    ;loads x with value 801
            ldab       #$80B    ;loads b with value 80B (bc we want to add b and x to store in M:80C) 
            ldaa       0,x      ;loads a with value of x (M:801) +0, which gives a a value of $C0
            staa       b,x      ;stores a in M:80C
            
            ldx        #$800    ;loads x with value 800
            ldab       #$80D    ;loads b with value 80D (bc we want to add b and x to store in M:80D) 
            ldaa       0,x      ;loads a with value of x (M:800) +0, which gives a a value of $E0
            staa       b,x      ;stores a in M:80D     
            
;***********************************************************************            
            rts     ;end statement

;**************************************************************
;*                 Interrupt Vectors                          *
;**************************************************************
            ORG   $FFFE
            DC.W  Entry           ; Reset Vector
