module SignExtended(
input [15:0] Instruction,
output reg [15:0] signExtout //sign extended immediates output. Max value should not be over 10-bits
);
//parsing data for immidiate values
reg [3:0] parseI;
reg [3:0] parseSB;
reg [9:0] parseUJ;
reg [3:0] parseLW;
reg [3:0] parseSW;
//opcode
reg [2:0] opcode;

//IntructionMemory DUT (.InstructionMemOut(Instruction));

//parameters used to know how to parse immediate output
parameter iType = 3'b001,
          sbType = 3'b100,
          ujType = 3'b101,
          lw = 3'b010,
          sw = 3'b011;
          
always @ (Instruction)
begin

opcode[2:0] = Instruction[2:0]; //assigning opcode as first 3-bits from memory instructions
case (opcode)

    iType: begin //I-Type instructions
         parseI[3:0] = Instruction[15:12];
         signExtout[15:0] = parseI[3:0]; //sets output to the parsed immidiates
    end
    
    sbType: begin //SB-Type instuctions
        parseSB[3] = Instruction[15];
        parseSB[2:0] = Instruction[5:3];
        signExtout[15:0] = {{12{parseSB[3]}}, parseSB[3:0]};
    end
    
    ujType: begin //UJ-Type instruction
        parseUJ[9:0] = Instruction[15:6];
        signExtout[15:0] = { {6{parseUJ[9]}}, parseUJ[9:0]};
    end
    
    lw: begin //load word is i-type parsing
        parseLW[3:0] = Instruction[15:12];
        signExtout[15:0] = {{12{parseLW[3]}}, parseLW[3:0]};
    end
    
    sw: begin //store word is s-type parsing and same as sb-type parsing
        parseSW[3] = Instruction[15];
        parseSW[2:0] = Instruction[5:3];
        signExtout[15:0] = {{12{parseSW[3]}}, parseSW[3:0]};
    end
    default: begin
        signExtout = 0; //basically do nothing
    end
endcase

end
endmodule