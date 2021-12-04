module ControlUnit(
input [15:0] Instruction,
output reg branch,
output reg jump,
output reg mem_read_write,
output reg mem_to_reg,
output reg [2:0] ALUOp, //1-6
output reg ALUSrc,
output reg RegWrite,
output reg halt
);

parameter ALU_A = 3'b000,
          ALU_I = 3'b001,
          LOAD = 3'b010,
          STORE = 3'b011,
          BRANCH = 3'b100,
          JAL = 3'b101,
          JALR = 3'b110,
          HALT = 3'b111;

reg [2:0] opcode;

initial begin
branch = 0;
jump = 0;
mem_read_write = 0; //do nothing
ALUOp = 0;
ALUSrc = 0;
RegWrite = 0;
mem_to_reg = 0;
halt = 0;
end


always @(Instruction) begin //added a;ways block change
opcode = Instruction[2:0]; //changed, put in always block
//end

//always @ (opcode) //opcode change
//begin
branch = 0;
jump = 0;
mem_read_write = 0; //do nothing
ALUOp = 0;
ALUSrc = 0;
RegWrite = 0;
halt = 0;

case (opcode)

    ALU_A: begin //Arithmatic Intructions
    ALUOp = 1; //operation 0, Arithmatic instructions
    ALUSrc = 0;
    RegWrite = 1; 
    mem_to_reg = 0;
    end
    
    ALU_I: begin //Immediate Instructions
    ALUOp = 2; //operation 1, immidiate arithmatic
    ALUSrc = 1; //gets immidiate sign extended from mux
    RegWrite = 1;
    mem_to_reg = 0;
    end
    
    LOAD: begin //Load Word Instruction
    ALUOp = 3; //operation 3, load word
    ALUSrc = 1; //for immidiates
    mem_read_write = 0; //read memory
    RegWrite = 1;
    mem_to_reg = 1; //memory
    end
    
    STORE: begin //Store Word Instruction
    ALUOp = 4;  //operation 5, store word
    ALUSrc = 1;
    mem_read_write = 1; //write memory
    end
    
    BRANCH: begin //branch instructions
    branch = 1;
    ALUOp = 5; //operation 6, branch
    ALUSrc = 1;
    end
    
    JAL: begin //Jump and Link Intruction
    jump = 1;
    RegWrite = 1;
    mem_read_write = 2;
    end
    
    JALR: //Jump and Link Register Intruction
    begin
    ALUOp = 6; //operation 7, jump and link register (regular jump does not require operation)
    ALUSrc = 1; //Immediate
    RegWrite = 1;
    mem_read_write = 2;
    end
    
    HALT: begin
    halt = 1; //halts everything :)
    end
    
endcase

end

endmodule