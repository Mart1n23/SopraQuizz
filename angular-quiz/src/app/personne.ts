export class Personne {
  constructor(
    private _email: string = '',
    private _password: string = '',
    private _first_name: string = '',
    private _last_name: string = ''
  ) {}
  /**
   * @return {string }
   */
  public get first_name(): string {
    return this._first_name;
  }

  /**
   * @param {string } value
   */
  public set first_name(value: string) {
    this._first_name = value;
  }

  /**
   * @return {string }
   */
  public get last_name(): string {
    return this._last_name;
  }

  /**
   * @param {string } value
   */
  public set last_name(value: string) {
    this._last_name = value;
  }
}
