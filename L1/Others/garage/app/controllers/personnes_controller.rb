class PersonnesController < ApplicationController
  before_action :set_personne, only: %i[ show edit update destroy ]

  # GET /personnes or /personnes.json
  def index
    @personnes = Personne.all
  end

  # GET /personnes/1 or /personnes/1.json
  def show
  end

  # GET /personnes/new
  def new
    @personne = Personne.new
  end

  # GET /personnes/1/edit
  def edit
  end

  # POST /personnes or /personnes.json
  def create
    @personne = Personne.new(personne_params)

    respond_to do |format|
      if @personne.save
        format.html { redirect_to @personne, notice: "Personne was successfully created." }
        format.json { render :show, status: :created, location: @personne }
      else
        format.html { render :new, status: :unprocessable_entity }
        format.json { render json: @personne.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /personnes/1 or /personnes/1.json
  def update
    respond_to do |format|
      if @personne.update(personne_params)
        format.html { redirect_to @personne, notice: "Personne was successfully updated." }
        format.json { render :show, status: :ok, location: @personne }
      else
        format.html { render :edit, status: :unprocessable_entity }
        format.json { render json: @personne.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /personnes/1 or /personnes/1.json
  def destroy
    @personne.destroy
    respond_to do |format|
      format.html { redirect_to personnes_url, notice: "Personne was successfully destroyed." }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_personne
      @personne = Personne.find(params[:id])
    end

    # Only allow a list of trusted parameters through.
    def personne_params
      params.require(:personne).permit(:nom, :prenom, :date_naissance)
    end
end
