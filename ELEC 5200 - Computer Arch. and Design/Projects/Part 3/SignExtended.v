module SignExtended(
input [15:0] InstructionMemory,
output reg [9:0] signIout //sign extended immediates output. Max value should not be over 10-bits
);
//parsing data for immidiate values
reg [3:0] parseI;
reg [3:0] parseSB;
reg [9:0] parseUJ;
reg [3:0] parseLW;
reg [3:0] parseSW;
//opcode
reg [2:0] opcode;


//parameters used to know how to parse immediate output
parameter iType = 3'b001,
          sbType = 3'b100,
          ujType = 3'b101,
          lw = 3'b010,
          sw = 3'b011;
          
always @ (InstructionMemory)
begin
//clears everything to zero
signIout = 0; //setting output to zero
opcode = 0;
parseI = 0;
parseSB = 0;
parseUJ = 0;
parseLW = 0;
parseSW = 0;
//setting opcode
opcode[2:0] = InstructionMemory[2:0]; //assigning opcode as first 3-bits from memory instructions
case (opcode)

    iType: begin //I-Type instructions
         parseI[3:0] = InstructionMemory[15:12];
         signIout[3:0] = parseI[3:0]; //sets output to the parsed immidiates
    end
    
    sbType: begin //SB-Type instuctions
        parseSB[3] = InstructionMemory[15];
        parseSB[2:0] = InstructionMemory[5:3];
        signIout[3:0] = parseSB[3:0];
    end
    
    ujType: begin //UJ-Type instruction
        parseUJ[9:0] = InstructionMemory[15:6];
        signIout[9:0] = parseUJ[9:0];
    end
    
    lw: begin //load word is i-type parsing
        parseLW[3:0] = InstructionMemory[15:12];
        signIout[3:0] = parseLW[3:0];
    end
    
    sw: begin //store word is s-type parsing and same as sb-type parsing
        parseSW[3] = InstructionMemory[15];
        parseSW[2:0] = InstructionMemory[5:3];
        signIout[3:0] = parseSW[3:0];
    end
endcase

end
endmodule